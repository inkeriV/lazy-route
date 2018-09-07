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

### Mikä jäi epäselväksi tai tuottanut vaikeuksia?
Jos olisi vielä ollut aikaa, olisin halunnut hioa ohjelman rakennetta.

### Viikolla käytetty tuntimäärä?

