# bank-search-rest-api
A simple rest api that allows searching through an Indian banks database

(That Indian banks database used is based on this repository: https://github.com/snarayanank2/indian_banks)

This api allows two types of searches for Indian banks:

Let's assume the url where the api has been deployed is example.com
1) Autocomplete search

<i>example.com/api/branches/automplete?q=QUERY&limit=LIMIT&offset=OFFSET</i>

This will show LIMIT number of banks starting from index OFFSET that have their branch name starting with QUERY. All results will be ordered by IFSC code.

2) Keyword search

<i>example.com/api/branches/?q=QUERY&limit=LIMIT&offset=OFFSET</i>

This will show LIMIT number of banks starting from index OFFSET that contain the keyword QUERY anywhere in their details. All results will be ordered by IFSC code.


<b>You can test this api here: https://bank-search-backend-meghashyam.herokuapp.com</b>


