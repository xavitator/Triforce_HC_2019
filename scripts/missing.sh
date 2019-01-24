#!/usr/bin/env bash

_RED=$(tput setaf 1 2> /dev/null || echo "")
_GREEN=$(tput setaf 2 2> /dev/null || echo "")
# _YELLOW=$(tput setaf 3 2> /dev/null || echo "")
# _BLUE=$(tput setaf 4 2> /dev/null || echo "")
# _PURPLE=$(tput setaf 5 2> /dev/null || echo "")
# _CYAN=$(tput setaf 6 2> /dev/null || echo "")
# _WHITE=$(tput setaf 7 2> /dev/null || echo "")
_END=$(tput sgr0 2> /dev/null || echo "")

OK="${_GREEN}✔${_END}"
KO="${_RED}✘${_END}"

ALGOS="A_etoile Algo_Hongrois Arbre_intervalle Bellman_Ford BFS CFC Cycle_detect DFS Dinitz Dijkstra Edmonds_Karp Floyd_Warshall Ford_Fulkerson Kruskal Prim Tas Tri_topo Union_find"
LANGUAGES="C++ Java Python"

printf "%-20s" ""

for LANG in ${LANGUAGES}; do
	printf "%-20s" "${LANG}"
done
printf "\\n"

for ALGO in ${ALGOS}; do
	printf "%-20s" "${ALGO}"
	for LANG in ${LANGUAGES}; do
		RES=${KO}
		if [ -d "${LANG}/${ALGO}" ]; then
			RES=${OK}
		fi
		printf "%s" "${RES}"
		for (( i = 0; i < 19; i++ )); do
			printf " "
		done
	done
	printf "\\n"
done
