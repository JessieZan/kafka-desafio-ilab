package com.kafka.server.utilitarios;

import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.io.*;
import java.util.ArrayList;

import com.kafka.server.service.ISalvarCsv;

import org.springframework.beans.factory.annotation.Autowired;

public class DownloadFileS3 {

	private static final String BUCKET = "group-3-bucket";
	// private static final String keyName = "csv_projeto_grupo-3.csv";

	public static ArrayList<String[]> downloadFile(String fileName)
			throws S3Exception, AwsServiceException, SdkClientException, IOException {

		AwsCredentialsProvider credentialsProvider = new AwsCredentialsProvider() {
			@Override
			public AwsCredentials resolveCredentials() {
				return new AwsCredentials() {
					@Override
					public String accessKeyId() {
						return System.getenv("AWS_ACCESS_KEY");
					}

					@Override
					public String secretAccessKey() {
						return System.getenv("AWS_SECRET_KEY");
					}
				};
			}
		};

		S3Client client = S3Client.builder()
				.region(Region.US_EAST_1)
				.credentialsProvider(credentialsProvider)
				.build();

		GetObjectRequest request = GetObjectRequest.builder()
				.bucket(BUCKET)
				.key(fileName)
				.build();

		ResponseInputStream<GetObjectResponse> inputStream = client.getObject(request);

		String fileName2 = new File(fileName).getName();

		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2));
		byte[] buffer = new byte[4096];

		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		
		inputStream.close();
		outputStream.close();

		BufferedReader reader = null;
		String line = "";
		ArrayList<String[]> dadosProdutos = new ArrayList<String[]>();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null) {
				
                String[] row = line.split(";");			
                dadosProdutos.add(row);

				System.out.println(row[1]);
				
            }
            return dadosProdutos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
			reader.close();
		}
    }
}
	
	
