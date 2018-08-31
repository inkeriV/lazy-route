### Testausdokumentti (kesken)

#### Yksikkötestaus
Ohjelman testauksessa on käytetty javan JUnit:ia yksikkötestaukseen ja JaCoCo:a testikattavuuden tarkasteluun.

#### Suorituskykytestaus
* (Tällä hetkellä) Dijkstran ja A-Starin suorituskykyä on testattu siihen kirjoitetulla metodilla ```testPerformance```, jolle annetaan parametriksi määrä, kuinka monta kertaa molempia algoritmejä halutaan testauksessa kutsua.
* ```testPerformance``` kutsuu metodia ```createRandomGraph```, joka luo 10000-alkioisen 1d taulukon, jonka sisältämät luvut ovat väliltä 1-99.
* Molemmille algoritmeille luodaan Graph-oliot, jotka saavat saman random-verkon.
* Suoritukseen menevä aika lasketaan millisekunteina ottamalla talteen nykyaika ennen ohjelman kutsumista ja sen jälkeen, ja lasketaan aikojen erotus.
* Tulosten tutkinta ja dokumentointi tulee myöhemmin..
