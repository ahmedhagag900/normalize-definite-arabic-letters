# normalize-definite-arabic-letters
This an ElasticSearch plugins that's implement a custom token filter <br>
The filter removes the definite arabic letter from arabic text <br>
without changing the root of the token or performing any stemming algorithms on it

examples:<br>

```الفراولة ==> فراولة``` <br>
```بالفراولة ==> فراولة```


# Configuration
read the following articale to check how to configure ```plugin-descriptor.properties``` file 
[https://www.elastic.co/guide/en/elasticsearch/plugins/current/plugin-authors.html]


# Installation
To install the plugin into elasticsearch <br>
download the ```elasticsearch-remove_arabic_defention_chracters-1.1.0.zip``` <br>
and open the cmd in the elasticsearch bin folder and type <br>
```elasticsearch-plugin install file:elasticsearch-remove_arabic_defention_chracters-1.1.0.zip```

# Dependancy
This plugin works on elasticsearch version ```7.10.2```
