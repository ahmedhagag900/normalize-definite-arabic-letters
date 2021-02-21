# normalize-definite-arabic-letters
This an ElasticSearch plugins that's implement a custom token filter <br>
The filter removes the definite arabic letter from arabic text without changing the root of 
the token

examples:<br>

```الفراولة ==> فراولة``` <br>
```بالفراولة ==> فراولة```


# Installation
To install the plugin into elasticsearch <br>
download the ```elasticsearch-remove_arabic_defention_chracters-1.1.0.zip``` <br>
and open the cmd in the elasticsearch bin folder and type <br>
```elasticsearch-plugin install file:[filepath]\elasticsearch-remove_arabic_defention_chracters-1.1.0.zip```

# Dependancy
This plugin works on elasticsearch version ```7.10.2```
