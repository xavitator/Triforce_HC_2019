
#include "libalgo.hpp"

template<typename T>
struct	s_ret_dfs
{
	std::map<T, T>					pi;
	std::map<T, unsigned int>		date_discover;
	std::map<T, unsigned int>		date_end;
};

template<typename T>
void					graph_dfs_pp(
							struct s_gla<T> *graph,
							struct s_ret_dfs<T> *res,
							std::set<T> &passed,
							unsigned int &t,
							T &u)
{
	passed.insert(u);
	t++;
	res->date_discover[u] = t;
	for (T v : graph->li_edges[u])
	{
		if (passed.find(v) == passed.end())
		{
			res->pi[v] = u;
			graph_dfs_pp(graph, res, passed, t, v);
		}
	}
	t++;
	res->date_end[u] = t;
}

template<typename T>
struct s_ret_dfs<T>		*graph_dfs(
							struct s_gla<T> *graph)
{
	struct s_ret_dfs<T>	*res;
	std::set<T>			passed;
	unsigned int		t;

	res = new struct s_ret_dfs<T>;
	t = 0;
	for (T u : graph->li_vertices)
	{
		if (passed.find(u) == passed.end())
			graph_dfs_pp(graph, res, passed, t, u);
	}
	return (res);
}
