#### verkko

kutsu

```
mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main
```

```
1 - 2 - 2 - 2 - 2 - 2 - 9 - 9 - 9 - 7
|   |   |   |   |   |   |   |   |   |
3 - 3 - 3 - 4 - 3 - 4 - 3 - 2 - 1 - 2
|   |   |   |   |   |   |   |   |   |
5 - 5 - 5 - 5 - 6 - 6 - 6 - 7 - 3 - 1
|   |   |   |   |   |   |   |   |   |
3 - 4 - 4 - 4 - 4 - 4 - 2 - 2 - 1 - 1
|   |   |   |   |   |   |   |   |   |
7 - 7 - 7 - 7 - 3 - 3 - 2 - 1 - 5 - 3
|   |   |   |   |   |   |   |   |   |
1 - 2 - 2 - 2 - 2 - 2 - 9 - 9 - 9 - 7
|   |   |   |   |   |   |   |   |   |
3 - 3 - 3 - 4 - 3 - 4 - 3 - 2 - 1 - 2
|   |   |   |   |   |   |   |   |   |
5 - 5 - 5 - 5 - 6 - 6 - 6 - 7 - 3 - 1
|   |   |   |   |   |   |   |   |   |
3 - 4 - 4 - 4 - 4 - 4 - 4 - 4 - 4 - 2
|   |   |   |   |   |   |   |   |   |
2 - 1 - 1 - 7 - 7 - 7 - 7 - 3 - 3 - 2
```

pitäis olla muotoa
```
mvn compile exec:java -Dexec.mainClass=lazyroute.main.Main -Dexec.args="1,1,1,1,2,3,2,1,2,3,1,2,3,4,2,4,1,1,1,1,1,2,1,2,1,4,2,4,2,4,2,1,2,2,1,1, 1 35 6 6 d"
``` 

#### suorituskyky

```
mvn compile exec:java -Dexec.mainClass=lazyroute.main.PerformanceTesting -Dexec.args="10"
```


