package br.com.nanodata.importxml.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);

}
