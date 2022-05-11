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

public class DownloadFileS3 {

	private static final String BUCKET = "group-3-bucket";
	// private static final String keyName = "csv_projeto_grupo-3.csv";

	public static void downloadFile(String fileName)
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

		ResponseInputStream<GetObjectResponse> InputStream = client.getObject(request);

		String fileName2 = new File(fileName).getName();

		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2));
		byte[] buffer = new byte[4096];

		int bytesRead = -1;

		while ((bytesRead = InputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		;
		InputStream.close();
		outputStream.close();

		BufferedReader reader = null;
		String line = "";

		try {
			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				System.out.println();
				String[] row = line.split(";");
				for (String string : row) {
					System.out.printf("%-10s ", string);
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}
}