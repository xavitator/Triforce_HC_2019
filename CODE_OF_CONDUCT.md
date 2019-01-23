# Code of conduct

On a une architecture de fichier qui ressemble à celle-ci:
```
$> tree
.
├── C++/
├── Java/
│   ├── BFS/
│   └── DFS/
├── Makefile
├── Python3/
├── README
└── tests/
    ├── BFS/
    └── DFS/
        ├── in1.txt
        └── out1.txt
```

Pour chaque langage, un sous dossier pour chaque algorithme, ainsi qu'un Makefile qui permet de lancer un algorithme sur un fichier d'entrée et écrit le résultat dans un fichier de sortie.
```
./prog [ALGO] [FILE_IN] [FILE_OUT]
```
Pour chaque algorithme, un sous dossier dans tests/, puis pour chaque test, la convention inN.txt et outN.txt.
Le makefile général servira à lancer tous les tests ou seulement certains tests.
Il permettra alors aussi de voir les algos qui manquent dans les langages.
