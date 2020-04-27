package com.hsbc.ratesapi.restassured;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;

import com.hsbc.ratesapi.utils.ResponseRepository;
import com.hsbc.ratesapi.utils.ServiceFactory;

public class RestAPIHelper extends ServiceFactory {

	public static SSLContext getSSLContext()
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

		TrustStrategy trust = new TrustStrategy() {

			public boolean isTrusted(X509Certificate[] chain, String authType) {

				return true;

			}

		};

		return SSLContexts.custom().loadTrustMaterial(trust).build();

	}

	@SuppressWarnings("deprecation")
	public static CloseableHttpClient getHttpClient(SSLContext sslContext) {

		return HttpClientBuilder.create().setSslcontext(sslContext).disableCookieManagement().build();

	}

	private static void performRequest(HttpUriRequest method) {

		ResponseHandler<String> handler = null;

		CloseableHttpResponse response = null;

		try (CloseableHttpClient client = getHttpClient(getSSLContext())) {

			response = client.execute(method);
			
			handler = new BasicResponseHandler();

			responseRepository = new ResponseRepository(
					new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response)));

		} catch (Exception e) {

			if (e instanceof HttpResponseException)
				try {
					responseRepository = new ResponseRepository(new RestResponse(
							response.getStatusLine().getStatusCode(), handler.handleResponse(response)));

				} catch (IOException e1) {

					throw new RuntimeException(e1.getMessage(), e1);
				}

		}
	}

	public static void main(String args[]) {
		
		performGetRequest("https://api.ratesapi.io/api/latest");
		
		System.out.println(responseRepository.getResponseObject().getResponseBody());
		
	}
	public static void performGetRequest(String uri) {

		try {

			performGetRequest(new URI(uri));

		} catch (URISyntaxException e) {

			throw new RuntimeException(e.getMessage(), e);
		}

	}

	private static void performGetRequest(URI uri) {

		HttpGet get = new HttpGet(uri);

		performRequest(get);

	}
}
