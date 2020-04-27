package com.hsbc.ratesapi.utils;

import static com.hsbc.ratesapi.utils.Constants.OBJECTREPOSITORYPATH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.hsbc.ratesapi.restassured.RestResponse;

public class ResponseRepository {

	/*********
	 * This class used to store and retrieve API response object form the file
	 ************/

	Object responseObject = null;

	File repositoryObjectFile = null;

	ObjectOutputStream objectOputputSteam = null;

	ObjectInputStream objectInputStream = null;

	public ResponseRepository() {

		repositoryObjectFile = new File(OBJECTREPOSITORYPATH);

	}

	public ResponseRepository(Object responseObject) {

		repositoryObjectFile = new File(OBJECTREPOSITORYPATH);

		this.responseObject = responseObject;

		storeResponseObject();

	}

	public RestResponse getResponseObject() {

		RestResponse restResponse = null;

		try {

			objectInputStream = new ObjectInputStream(new FileInputStream(repositoryObjectFile));

			try {

				restResponse = (RestResponse) objectInputStream.readObject();

			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			}

			objectInputStream.close();

		}

		catch (IOException e) {

			e.printStackTrace();
		}
		
		return restResponse;

	}

	public void storeResponseObject() {

		try {

			objectOputputSteam = new ObjectOutputStream(new FileOutputStream(repositoryObjectFile));

			objectOputputSteam.writeObject(responseObject);

			objectOputputSteam.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
