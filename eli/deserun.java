    // Instantiate a client.
    try (SpartanClient client = SpartanClient.create()) {

      // Prepare the request, set the name of the method to call.
      ReadRequest request =
          ReadRequest.newBuilder()
              .setTableName("Singers")
              .setKey(KeySet.newBuilder().addKeys("Id1").build())
              .addProjection("Name")
              .addProjection("SingerInfo")
              .build();

      // Read using a specific method.
      ReadResponse response = client.read("GetSingerInfo", request);
      for (Row row : response.getRowsList()) {
        System.out.printf("%s %s\n", row.getCells(0).getValue().toStringUtf8(), row.getCells(1).getValue().toStringUtf8());
      }
    }  
