package app.service;

import app.dto.DataRequest;

import javax.xml.crypto.Data;

public interface AppAService {

    String getData(DataRequest dataRequest) throws Exception;
}
