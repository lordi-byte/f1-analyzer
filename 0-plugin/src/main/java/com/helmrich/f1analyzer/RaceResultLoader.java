package com.helmrich.f1analyzer;

import com.helmrich.f1analyzer.domain.interfaces.RaceResultInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RaceResultLoader implements RaceResultInterface {
    @Override
    public StringBuffer getRaceResult(int year, int round) throws IOException {
        String queryString = String.format("https://ergast.com/api/f1/%d/%d", year, round);
        URL url = new URL(queryString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        return readResponse(con);
    }

    private StringBuffer readResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content;
    }
}
