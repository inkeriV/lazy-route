Helsingin yliopiston aineopintojen harjoitustyö, Tietorakenteet ja algoritmit, loppukesä 2018 -kurssilla tehtävä ohjelma.

Lazy-route on ohjelma, joka etsii painotetussa verkossa (ei negatiivisia arvoja) kahden solmun välisen kevyimmän reitin. Ohjelmaa voi käyttää mm. maastossa helppokulkuisimman reitin etsimiseen, missä kartta voidaan ajatella ruudukkona, jonka yksi ruutu on lähtöpiste, yksi ruutu on loppupiste ja muut ruudut kuvaavat maaston maaston helppokulkuisuutta tai mahdollista estettä ruuduille annetuilla painoilla. Ruudukko kuvataan painotettuna verkkona G=(V,E), missä kaaren paino kuvaa kuvaa kulkemisen hankaluutta viereiseen ruutuun, eli kaaren päässä olevaan solmuun.
Työn aikana vertaan Dijkstran algoritmia sekä A*-algoritmia. Valitsin Dijkstran algoritmin Bellman-Fordin algoritmin sijaan, koska Dijkstran aikavaativuus on O(|E|+|V|log|V|), kun taas Bellman-Fordin aikavaativuus on O(|E||V|). A*-algoritmi on puolestaan yleisesti suositumpi ja yleensä nopeampi kuin Dijkstra.

***Dijkstran algoritmi
* tietorakenteet minimikekoa ja vieruslistaa
* tavoite aikavaativuus O(|E|+|V|log|V|)
* tavoite tilavaativuus O(|V|)

***A*-algoritmi
* tietorakenteet minimikeko ja vieruslista
* tavoite aikavaativuus O(|E|+|V|log|V|)
* tavoite tilavaativuus O(|V|)

Ohjelma saa syötteenään verkon G, sekä alku- ja lähtösolmun.
