package com.example;

import java.util.concurrent.ExecutionException;

import org.infinispan.client.rest.RestResponse;
import org.infinispan.client.rest.configuration.RestClientConfigurationBuilder;
import org.infinispan.client.rest.impl.okhttp.RestClientOkHttp;

public class Reproducer {

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      RestClientOkHttp restClient = new RestClientOkHttp(new RestClientConfigurationBuilder().build());
      RestResponse response1 = restClient.cacheManager("default").stats().toCompletableFuture().get();
      System.out.println(response1.getBody());


   }
}
