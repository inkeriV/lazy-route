## Viikkoraportti 2

### Mitä tein tällä viikolla?
Kirjoitin koodia monta pitkää päivää, mutta en saanut mitään aikaan. Ensin aloin tehdä jonkinlaista testiverkkoa ja siinä vekslasin pari kertaa edes takaisin teenkö solmuista olioita vai en. Sitten aloin tehdä dijkstraa, mutta minimikeon kohdalla ajattelinkin ohjeista huolimatta ruveta tekemään kekoa ilman importteja. Sekin jäi kesken ja tein sitten edes jonkin laiset verkon luomiset, joten en saanut juuri mitään aikaan. Testitkin jäi tekemättä.

### Miten ohjelma on edistynyt?
Aivan liian hitaasti.

### Mitä opin tällä viikolla?
Jälleen kerran hyvin suunniteltu on puoliksi tehty :')

### Mikä jäi epäselväksi tai tuottanut vaikeuksia?
Maven on minulle ihan uusi juttu ja olin tänään vähän hukassa kun yritin selvittää ratkaisua siihen että se herjaa tällaista:
Failed to execute goal org.codehaus.mojo:exec-maven.plugin:1.6.0:java (default-cli) on project lazy-route: 
The parameters 'mainClass' for goal org.codehaus.mojo:exec-maven-plugin:1.6.0:java are missing or invalid (edit: 6.8. ongelma ratkesi).

Katsoin stackoverflowsta muutamia vastauksia kyseiseen ongelmaan, mutta en vielä ihan hiffannut miten saan tuon korjattua.. Ilmeisesti tarvitsen mainClass parametrit, koska sellaisia minulla ei ainakaan ole. 
Hämmentää hieman sekin, että välillä suoritus toimi ongelmitta, välillä niitä taas tuli, mutta en katsonut vasta kun tänään tarkemmin, että mikä se ongelma oli.

### Mitä teen seuraavaksi?
Yritän selvittää tuon maven-ongelman. Sitten teen kunnon suunnitelman siitä, miten etenen. Luultavasti teen sovellusta kuitenkin vielä javan importeilla, niin saan jotain aikaankin. Sitten sille testit asap. Ja kuhan ehdin nii päivitän vähän määrittelydokumenttia.

### Viikolla käytetty tuntimäärä:
22h 45min
