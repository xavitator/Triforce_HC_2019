#include "libalgo.hpp"
#include "utils/print.hpp"
#include "utils/transpose.hpp"
// Algos
#include "DFS/DFS.hpp"
#include "BFS/BFS.hpp"
#include "Bellman_Ford/Bellman_Ford.hpp"
#include "CFC/CFC.hpp"
#include "Cycle_detect/Cycle_detect.hpp"
#include "Tri_topo/Tri_topo.hpp"

#define SIZE_GLA_LIST		5
#define SIZE_GLAW_LIST		1

struct s_gla<int>			*gla_list[SIZE_GLA_LIST] = {NULL};
struct s_glaw<std::string>	*glaw_list[SIZE_GLAW_LIST] = {NULL};

void	init_globals_gla();
void	end_globals_gla();

void	test_cycle_detect(void);
void	test_cfc(void);
void	test_bellman_ford(void);
void	test_bfs(void);
void	test_dfs(void);
void	test_tri_topo(void);

int		main()
{
	init_globals_gla();

	test_tri_topo();
	// test_cycle_detect();
	// test_cfc();
	// test_bellman_ford();
	// test_bfs();
	// test_dfs();

	end_globals_gla();
	return (0);
}

void	test_tri_topo(void)
{
	s_gla<int>			*gla = gla_list[4];
	auto				res = graph_tri_topo(gla);

	std::cout << "=== Tri topo ===" << std::endl;
	while (res->empty() == false)
	{
		std::cout << res->top() << " ";
		res->pop();
	}
	std::cout << std::endl;

	delete res;
}

void	test_cycle_detect(void)
{
	s_gla<int>			*gla = gla_list[0];

	std::cout << "=== Cycle detection ===" << std::endl;
	std::cout << graph_cycle_detect(gla) << std::endl;
	gla->li_edges[8].insert(6);
	std::cout << graph_cycle_detect(gla) << std::endl;
}

void	test_cfc(void)
{
	s_gla<int>			*gla = gla_list[1];

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
}

void	test_bellman_ford(void)
{
	s_glaw<std::string>		*gla = glaw_list[0];

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
}

void	test_bfs(void)
{
	s_gla<int>		*gla = gla_list[2];

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
}

void	test_dfs(void)
{
	s_gla<int>		*gla = gla_list[3];

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
}

void	init_globals_gla()
{
	gla_list[0] = new s_gla<int>();
	gla_list[0]->li_vertices.insert(1);
	gla_list[0]->li_vertices.insert(2);
	gla_list[0]->li_vertices.insert(3);
	gla_list[0]->li_vertices.insert(4);
	gla_list[0]->li_vertices.insert(5);
	gla_list[0]->li_vertices.insert(6);
	gla_list[0]->li_vertices.insert(7);
	gla_list[0]->li_vertices.insert(8);
	gla_list[0]->li_edges[1].insert(2);
	gla_list[0]->li_edges[2].insert(3);
	gla_list[0]->li_edges[1].insert(3);
	gla_list[0]->li_edges[3].insert(4);
	gla_list[0]->li_edges[4].insert(5);
	gla_list[0]->li_edges[5].insert(7);
	gla_list[0]->li_edges[6].insert(7);
	gla_list[0]->li_edges[7].insert(8);

	gla_list[1] = new s_gla<int>();
	gla_list[1]->li_vertices.insert(1);
	gla_list[1]->li_vertices.insert(2);
	gla_list[1]->li_vertices.insert(3);
	gla_list[1]->li_vertices.insert(4);
	gla_list[1]->li_vertices.insert(5);
	gla_list[1]->li_vertices.insert(6);
	gla_list[1]->li_vertices.insert(7);
	gla_list[1]->li_vertices.insert(8);
	gla_list[1]->li_edges[1].insert(2);
	gla_list[1]->li_edges[2].insert(1);
	gla_list[1]->li_edges[2].insert(3);
	gla_list[1]->li_edges[1].insert(3);
	gla_list[1]->li_edges[3].insert(4);
	gla_list[1]->li_edges[4].insert(3);
	gla_list[1]->li_edges[4].insert(5);
	gla_list[1]->li_edges[5].insert(7);
	gla_list[1]->li_edges[6].insert(7);
	gla_list[1]->li_edges[7].insert(8);
	gla_list[1]->li_edges[8].insert(6);

	gla_list[2] = new s_gla<int>();
	gla_list[2]->li_vertices.insert(1);
	gla_list[2]->li_vertices.insert(2);
	gla_list[2]->li_vertices.insert(3);
	gla_list[2]->li_vertices.insert(4);
	gla_list[2]->li_vertices.insert(5);
	gla_list[2]->li_vertices.insert(6);
	gla_list[2]->li_edges[1].insert(2);
	gla_list[2]->li_edges[2].insert(4);
	gla_list[2]->li_edges[2].insert(3);
	gla_list[2]->li_edges[3].insert(5);
	gla_list[2]->li_edges[4].insert(6);
	gla_list[2]->li_edges[5].insert(6);

	gla_list[3] = new s_gla<int>();
	gla_list[3]->li_vertices.insert(1);
	gla_list[3]->li_vertices.insert(2);
	gla_list[3]->li_vertices.insert(3);
	gla_list[3]->li_vertices.insert(4);
	gla_list[3]->li_vertices.insert(5);
	gla_list[3]->li_edges[1].insert(3);
	gla_list[3]->li_edges[2].insert(3);
	gla_list[3]->li_edges[3].insert(4);
	gla_list[3]->li_edges[4].insert(1);
	gla_list[3]->li_edges[4].insert(2);

	gla_list[4] = new s_gla<int>();
	gla_list[4]->li_vertices.insert(1);
	gla_list[4]->li_vertices.insert(2);
	gla_list[4]->li_vertices.insert(3);
	gla_list[4]->li_vertices.insert(4);
	gla_list[4]->li_vertices.insert(5);
	gla_list[4]->li_edges[1].insert(2);
	gla_list[4]->li_edges[1].insert(3);
	gla_list[4]->li_edges[2].insert(4);
	gla_list[4]->li_edges[3].insert(4);
	gla_list[4]->li_edges[4].insert(5);

	glaw_list[0] = new s_glaw<std::string>;
	glaw_list[0]->li_vertices.insert("S");
	glaw_list[0]->li_vertices.insert("A");
	glaw_list[0]->li_vertices.insert("B");
	glaw_list[0]->li_vertices.insert("C");
	glaw_list[0]->li_vertices.insert("D");
	glaw_list[0]->li_vertices.insert("E");
	glaw_list[0]->li_edges_w["S"].insert(std::make_pair("E", 8));
	glaw_list[0]->li_edges_w["S"].insert(std::make_pair("A", 10));
	glaw_list[0]->li_edges_w["E"].insert(std::make_pair("D", 1));
	glaw_list[0]->li_edges_w["D"].insert(std::make_pair("A", -4));
	glaw_list[0]->li_edges_w["D"].insert(std::make_pair("C", -1));
	glaw_list[0]->li_edges_w["A"].insert(std::make_pair("C", 2));
	glaw_list[0]->li_edges_w["C"].insert(std::make_pair("B", -2));
	glaw_list[0]->li_edges_w["B"].insert(std::make_pair("A", 1));
}

void	end_globals_gla()
{
	for (size_t i = 0; i < SIZE_GLA_LIST; i++) {
		delete gla_list[i];
	}
	for (size_t i = 0; i < SIZE_GLAW_LIST; i++) {
		delete glaw_list[i];
	}
}
