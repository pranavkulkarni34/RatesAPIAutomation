package com.hsbc.ratesapi.utils;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseParser {

	public ResponseParser() {

	}

	HashMap<String, String> responseDetails = new HashMap<String, String>();

	public HashMap<String, String> parseJSON(JSONObject jsonObject) {

		for (String key : jsonObject.keySet()) {

			responseDetails.put(key, String.valueOf(jsonObject.get(key)));

			if (jsonObject.get(key) instanceof JSONObject) {

				parseJSON(jsonObject.getJSONObject(key));

			} else if (jsonObject.get(key) instanceof JSONArray) {

				parseJSONArray((JSONArray) jsonObject.get(key));

			}

		}
		
		return responseDetails;

	}

	public void parseJSONArray(JSONArray jsonArray) {

		for (int i = 0; i < jsonArray.length(); i++) {

			if (jsonArray.get(i) instanceof JSONObject) {

				parseJSON(jsonArray.getJSONObject(i));

			} else if (jsonArray.get(i) instanceof JSONArray) {

				parseJSONArray((JSONArray) jsonArray.get(i));

			}

		}

	}

}
