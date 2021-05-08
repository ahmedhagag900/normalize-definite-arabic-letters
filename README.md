# normalize-definite-arabic-letters
This an ElasticSearch plugins that's implement a custom token filter <br>
The filter removes the definite arabic letter from arabic text ,without changing the root of the token <br>
or performing any stemming algorithms on it.

examples:<br>

```الفراولة ==> فراولة``` <br>
```بالفراولة ==> فراولة```


# Configuration
read the following articale to check how to configure ```plugin-descriptor.properties``` file 
[https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-authors.html]

# Download
Link:<br>
[https://raw.githubusercontent.com/ahmedhagag900/normalize-definite-arabic-letters/main/elasticsearch-remove_arabic_defention_chracters-1.1.0.zip]

# Installation
To install the plugin into elasticsearch <br>
download the ```elasticsearch-remove_arabic_defention_chracters-1.1.0.zip``` <br>
and open the cmd in the elasticsearch bin folder and type <br>
```elasticsearch-plugin install file:elasticsearch-remove_arabic_defention_chracters-1.1.0.zip```
Check this linke for more details on how to install custom plugins to elasticsearch enginge
[https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-management-custom-url.html]

# Example
Request body:
```
GET /_analyze
{
  "tokenizer": "standard",
  "filter": ["Normalize_definite_arabic_letters"],
  "text": ["عصير جهينة بالمانجو"]
}
```
<br>
Response:

```{
  "tokens" : [
    {
      "token" : "عصير",
      "start_offset" : 0,
      "end_offset" : 4,
      "type" : "<ALPHANUM>",
      "position" : 0
    },
    {
      "token" : "جهينة",
      "start_offset" : 5,
      "end_offset" : 10,
      "type" : "<ALPHANUM>",
      "position" : 1
    },
    {
      "token" : "مانجو",
      "start_offset" : 11,
      "end_offset" : 19,
      "type" : "<ALPHANUM>",
      "position" : 2
    }
  ]
} 
```


# Dependancy
This plugin works on elasticsearch version ```7.10.2``` <br>
change the elasticsearch version from ```pom.xml``` file under ```<elasticsearch.version>``` tag into your elasticsearch version

