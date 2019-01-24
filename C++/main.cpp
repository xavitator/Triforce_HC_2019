#include "libalgo.hpp"
#include "utils/print.hpp"
#include "utils/transpose.hpp"
// Algos
#include "DFS/DFS.hpp"
#include "BFS/BFS.hpp"
#include "Bellman_Ford/Bellman_Ford.hpp"
#include "CFC/CFC.hpp"
#include "Cycle_detect/Cycle_detect.hpp"

void	test_cycle_detect(void);
void	test_cfc(void);
void	test_bellman_ford(void);
void	test_bfs(void);
void	test_dfs(void);

int		main()
{
	test_cycle_detect();
	// test_cfc();
	// test_bellman_ford();
	// test_bfs();
	// test_dfs();
	return (0);
}

void	test_cycle_detect(void)
{
	s_gla<int>			*gla;

	gla = new s_gla<int>();
	gla->li_vertices.insert(1);
	gla->li_vertices.insert(2);
	gla->li_vertices.insert(3);
	gla->li_vertices.insert(4);
	gla->li_vertices.insert(5);
	gla->li_vertices.insert(6);
	gla->li_vertices.insert(7);
	gla->li_vertices.insert(8);
	gla->li_edges[1].insert(2);
	gla->li_edges[2].insert(3);
	gla->li_edges[1].insert(3);
	gla->li_edges[3].insert(4);
	gla->li_edges[4].insert(5);
	gla->li_edges[5].insert(7);
	gla->li_edges[6].insert(7);
	gla->li_edges[7].insert(8);

	std::cout << "=== Cycle detection ===" << std::endl;
	std::cout << graph_cycle_detect(gla) << std::endl;
	gla->li_edges[8].insert(6);
	std::cout << graph_cycle_detect(gla) << std::endl;

	delete gla;
}

void	test_cfc(void)
{
	s_gla<int>			*gla;

	gla = new s_gla<int>();
	gla->li_vertices.insert(1);
	gla->li_vertices.insert(2);
	gla->li_vertices.insert(3);
	gla->li_vertices.insert(4);
	gla->li_vertices.insert(5);
	gla->li_vertices.insert(6);
	gla->li_vertices.insert(7);
	gla->li_vertices.insert(8);
	gla->li_edges[1].insert(2);
	gla->li_edges[2].insert(1);
	gla->li_edges[2].insert(3);
	gla->li_edges[1].insert(3);
	gla->li_edges[3].insert(4);
	gla->li_edges[4].insert(3);
	gla->li_edges[4].insert(5);
	gla->li_edges[5].insert(7);
	gla->li_edges[6].insert(7);
	gla->li_edges[7].insert(8);
	gla->li_edges[8].insert(6);

	// print_gla(gla);

	auto res = graph_cfc(gla);

	for (auto s : *res)
	{
		for (auto elem : s)
		{
			std::cout << elem << " ";
		}
		std::cout << std::endl;
	}

	delete res;
	delete gla;
}

void	test_bellman_ford(void)
{
	s_glaw<std::string>		*gla;

	gla = new s_glaw<std::string>;
	gla->li_vertices.insert("S");
	gla->li_vertices.insert("A");
	gla->li_vertices.insert("B");
	gla->li_vertices.insert("C");
	gla->li_vertices.insert("D");
	gla->li_vertices.insert("E");
	gla->li_edges_w["S"].insert(std::make_pair("E", 8));
	gla->li_edges_w["S"].insert(std::make_pair("A", 10));
	gla->li_edges_w["E"].insert(std::make_pair("D", 1));
	gla->li_edges_w["D"].insert(std::make_pair("A", -4));
	gla->li_edges_w["D"].insert(std::make_pair("C", -1));
	gla->li_edges_w["A"].insert(std::make_pair("C", 2));
	gla->li_edges_w["C"].insert(std::make_pair("B", -2));
	gla->li_edges_w["B"].insert(std::make_pair("A", 1));

	auto res = graph_bellman_ford(gla, std::string("S"));

	std::cout << "=== Bellman Ford ===" << std::endl;
	for (auto it = res->pi.begin(); it != res->pi.end(); ++it)
	{
		std::cout << "P(" << it->first << ") = " << it->second << std::endl;
	}
	std::cout << std::endl;
	for (auto it = res->distance.begin(); it != res->distance.end(); ++it)
	{
		std::cout << "d(" << it->first << ") = " << it->second << std::endl;
	}

	delete res;
	delete gla;
}

void	test_bfs(void)
{
	s_gla<int>		*gla;

	gla = new s_gla<int>();
	gla->li_vertices.insert(1);
	gla->li_vertices.insert(2);
	gla->li_vertices.insert(3);
	gla->li_vertices.insert(4);
	gla->li_vertices.insert(5);
	gla->li_vertices.insert(6);
	gla->li_edges[1].insert(2);
	gla->li_edges[2].insert(4);
	gla->li_edges[2].insert(3);
	gla->li_edges[3].insert(5);
	gla->li_edges[4].insert(6);
	gla->li_edges[5].insert(6);

	auto res = graph_bfs(gla, 1);

	std::cout << "=== BFS ===" << std::endl;
	for (auto it = res->pi.begin(); it != res->pi.end(); ++it)
	{
		std::cout << "P(" << it->first << ") = " << it->second << std::endl;
	}
	std::cout << std::endl;
	for (auto it = res->distance.begin(); it != res->distance.end(); ++it)
	{
		std::cout << "d(" << it->first << ") = " << it->second << std::endl;
	}

	delete res;
	delete gla;
}

void	test_dfs(void)
{
	s_gla<int>		*gla;

	gla = new s_gla<int>();
	gla->li_vertices.insert(1);
	gla->li_vertices.insert(2);
	gla->li_vertices.insert(3);
	gla->li_vertices.insert(4);
	gla->li_vertices.insert(5);
	gla->li_edges[1].insert(3);
	gla->li_edges[2].insert(3);
	gla->li_edges[3].insert(4);
	gla->li_edges[4].insert(1);
	gla->li_edges[4].insert(2);

	auto res = graph_dfs(gla);

	std::cout << "=== DFS ===" << std::endl;
	for (auto it = res->pi.begin(); it != res->pi.end(); ++it)
	{
		std::cout << "P(" << it->first << ") = " << it->second << std::endl;
	}
	std::cout << std::endl;
	for (auto it = res->date_discover.begin(); it != res->date_discover.end(); ++it)
	{
		std::cout << "d(" << it->first << ") = " << it->second << std::endl;
	}
	std::cout << std::endl;
	for (auto it = res->date_end.begin(); it != res->date_end.end(); ++it)
	{
		std::cout << "f(" << it->first << ") = " << it->second << std::endl;
	}

	delete res;
	delete gla;
}
