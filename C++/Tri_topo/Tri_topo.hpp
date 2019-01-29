
#include "libalgo.hpp"

template<typename T>
static void			tri_topo_pp(
							T u,
							struct s_gla<T> *graph,
							std::set<T> & passed,
							std::stack<T> *res)
{
	passed.insert(u);
	for (T v : graph->li_edges[u])
	{
		if (passed.find(v) == passed.end())
			tri_topo_pp(v, graph, passed, res);
	}
	res->push(u);
}

template<typename T>
std::stack<T>		*graph_tri_topo(
							struct s_gla<T> *graph)
{
	std::stack<T>		*res;
	std::set<T>			passed;

	res = new std::stack<T>();
	for (T s : graph->li_vertices)
	{
		if (passed.find(s) == passed.end())
			tri_topo_pp(s, graph, passed, res);
	}
	return (res);
}
