#include "libalgo.hpp"
#include "DFS/DFS.hpp"
#include "BFS/BFS.hpp"

void	test_bfs(void);
void	test_dfs(void);

int		main()
{
	test_bfs();
	test_dfs();
	return (0);
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
