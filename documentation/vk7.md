## Viikkoraportti 7

### Mitä tein tällä viikolla?
Muokkasin ohjelmakoodia, siistin, koodia, kirjoittelin dokumentit kuntoon, tein vielä muutamia testejä.

### Miten ohjelma on edistynyt?
Ohjelma on nyt valmis. Hiottavaa olisi vielä ollut, mutta kaikkea ei ehdi..

### Mitä opin tällä viikolla?
Opin, miten saan tallennettua ohjelman printtaaman tulosteen, ilman, että tuloste on ollut tallennettuna.
```
final ByteArrayOutputStream output = new ByteArrayOutputStream();
System.setErr(new PrintStream(output));
```
Näin pystyin testaamaan main-metodiakin, kun ohjelmaa kutsutaan komentoriviltä.

### Mitä olisin halunnut tehdä paremmin?
Jos olisin ehtinyt, korjaisin hieman ohjelman rakennetta. Graph luokan getPath()-metodi on mielestäni aika hirveä. Jopa sen nimentä on vaikeaa, sillä se tekee niin monta asiaa: luo verkon presentaatioita, kutsuu itse reitin laskennan suorittavia metodeja, ottaa vastaan path-olion, tekee siitä stringin ja palauttaa sen -__- Muutenkin metodikutsujonoa olisi voinut miettiä vähän järkevämmäksi. 
Toinen juttu on, että output on aika kämänen. Olisi ollut kiva tehdä jotain vähän hienompaa, mutta käyttöliittymä ei ollut kurssin keskeisin asia, ja itsekin ajattelin, että tärkeämpää saada ohjelma toimimaan ja oppia niitä asioita, mitä oli tarkoitus.

### Viikolla käytetty tuntimäärä?

