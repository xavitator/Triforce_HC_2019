
#include "libalgo.hpp"

template<typename T>
static void				CFC_PP1(s_gla<T> *graph, T u, std::set<T> & passed, std::stack<T> &pile)
{
	passed.insert(u);
	for (T v : graph->li_edges[u])
	{
		if (passed.find(v) == passed.end())
			CFC_PP1(graph, v, passed, pile);
	}
	pile.push(u);
}

template<typename T>
static void				CFC_PP2(s_gla<T> *graph, T u, std::set<T> & passed, std::set<T> & C)
{
	passed.insert(u);
	C.insert(u);
	for (T v : graph->li_edges[u])
		if (passed.find(v) == passed.end())
			CFC_PP2(graph, v, passed, C);
}

template<typename T>
std::set<std::set<T>>	*graph_cfc(s_gla<T> *graph)
{
	std::set<std::set<T>>	*res;
	std::stack<T>			pile;
	std::set<T>				passed;

	res = new std::set<std::set<T>>;
	for (T u : graph->li_vertices)
	{
		if (passed.find(u) == passed.end())
			CFC_PP1(graph, u, passed, pile);
	}
	passed = std::set<T>();
	transpose_gla(graph);
	while (pile.empty() == false)
	{
		std::set<T> C;
		T x;

		x = pile.top();
		pile.pop();
		if (passed.find(x) == passed.end())
		{
			CFC_PP2(graph, x, passed, C);
			res->insert(C);
		}
	}
	transpose_gla(graph);
	return (res);
}
