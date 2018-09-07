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

Viime tunneilla opin myös, miten javadocsit saa näkyviin gittiin. En tiennyt että documentation kansion pitää olla nimenomaan docs, mutta the more u know :)

### Mitä olisin halunnut tehdä paremmin?
Jos olisin ehtinyt, korjaisin hieman ohjelman rakennetta. Graph luokan getPath()-metodi on mielestäni aika hirveä. Jopa sen nimentä on vaikeaa, sillä se tekee niin monta asiaa: luo verkon presentaatioita, kutsuu itse reitin laskennan suorittavia metodeja, ottaa vastaan path-olion, tekee siitä stringin ja palauttaa sen -__- Muutenkin metodikutsujonoa olisi voinut miettiä vähän järkevämmäksi. 
Toinen juttu on, että output on aika kämänen. Olisi ollut kiva tehdä jotain vähän hienompaa, mutta käyttöliittymä ei ollut kurssin keskeisin asia, ja itsekin ajattelin, että tärkeämpää saada ohjelma toimimaan ja oppia niitä asioita, mitä oli tarkoitus.

### Muuta kommenttia
Oli aika karmea ja samalla ehkä kaikkein hyödyllisin kurssi tähän asti :D Jossain puolessa välissä kurssia kun pääsin vähän vauhtiin niin oli välillä ihan kivaa. Harmittaa, että siinä juuri kesti niin kauan ja sen taki työ on aika yksinkertainen. Mutta olen tyytyväinen, että sain sen tehtyä ja ohjelma toimii ja opin kaikenlaista jännää. Niin että nyt kun sen on kärvistellyt läpi niin voi sanoa että kiva kurssi :DD

### Viikolla käytetty tuntimäärä?
16h ~15min
