### Testausdokumentti (KESKEN)

#### Yksikkötestaus
Ohjelman testauksessa on käytetty javan JUnit:ia yksikkötestaukseen ja JaCoCo:a testikattavuuden tarkasteluun.
####### Yksikkötestaus luokittain
```Path```
Dijkstran ja A-starin testaus on aika puutteellista. Testasin niiden oikeellisuutta vain pienillä verkoilla katsomalla tuloksesta, että lyhin reitti on oikein. 

Suorituskykytestaus-luokan ```createRandomGraph```-metodia on testattu yksinkertaisesti tarkastamalla, että kaikki verkon alkiot ovat alle 100.


#### Suorituskykytestaus
Testauskoodi paketissa/luokassa ```lazyroute.main.PerformanceTesting```.
Dijkstralle ja A-Starille molemmille kutsutaan samaa 1000 x 1000 verkkoa, jossa solmujen painot on generoitu satunnaisesti väliltä 1-99. Suorituskykyä voi testata komennolla ```mvn compile exec:java -Dexec.mainClass=lazyroute.main.PerformanceTesting -Dexec.args="1"```. Halutut testauskerrat voi antaa argumenttina (esimerkkikäskyssä kutsutaan kerran). Jokaiselle testauskerralle luodaan uusi verkko.
Tiralabran [ohjeiden](https://github.com/TiraLabra/2018_loppu/wiki/Suorituskykytestauksesta) mukaan nykyhetken aika tallennetaan ennen ohjelman kutsumista ja sen jälkeen ja tulostetaan näiden erotus.
Outputtina on tuloste siitä, kuinka kauan kummallakin algoritmilla kesti millisekunteina.

Testasin suorituskykyä kutsumalla main-metodia kolmeen erilliseen kertaan, joissa kaikissa algoritmeja testattiin 21 kertaa. Alla tuloksia. Tulokset kullakin kerralla on järjestetty suuruusjärjestykseen, joten esim. ensimmäiset luvut eivät ole tuloksia samasta verkosta.
####### 1. kerta
```
A*: 348, 349, 355, 369, 374, 376, 379, 380, 383, 388, 396, 399, 407, 409, 412, 422, 434, 441, 460, 476, 753
mediaani: 396

D : 389, 401, 405, 417, 422, 422, 423, 423, 430, 442, 445, 449, 457, 466, 468, 476, 480, 492, 501, 521, 911
mediaani: 445
```

####### 2. kerta
```
A*: 809, 840, 853, 857, 860, 863, 864, 871, 886, 887, 890, 890, 891, 891, 894, 903, 940, 1014, 1092, 1117, 1605
mediaani: 890

D : 909, 910, 912, 914, 920, 934, 935, 935, 944, 949, 956, 960, 965, 967, 995, 996, 997, 1026, 1035, 1076, 1740
mediaani: 956
```

####### 3. kerta
```
A*: 551, 552, 557, 558, 558, 559, 561, 562, 567, 569, 575, 582, 585, 606, 614, 622, 641, 648, 656, 779, 1484
mediaani: 575

D : 583, 599, 599, 615, 621, 628, 628, 639, 640, 641, 645, 648, 679, 701, 702, 724, 735, 783, 790, 819, 1402
mediaani: 645
```

Tuloksista näkyy, että A-Star on tehokkaampi. A-Starin lyhimmät ja pisimmiät ajat ovat myös yhtä poikkeusta lukuunottamatta pienemmät kuin Dijkstran.





