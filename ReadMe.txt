1. check out the project
2. import into eclipse as gradle project
3. execute gradle clean build. This will create war file
4. using chrome postman, send post request to get the latitude and longitude of the shop
url - http://localhost:8080/locate/location/
content type - JSON
payload -
 {
  "shopName": "balaji",
      "shopAddress": {
           "number":"1234",
	        "postCode":"411021"
		    }
		         
			 }





 5. using chrome postman, execute get request to get the address of the shop
 http://localhost:8080/locate/shop?customerLatitude=21.1983559&customerLongitude=72.8261718
