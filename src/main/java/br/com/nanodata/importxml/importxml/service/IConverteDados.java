package br.com.nanodata.importxml.importxml.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);

}
