
#include "libalgo.hpp"

template<typename T>
void	transpose_gla(s_gla<T> *graph)
{
	std::map<T, std::set<T>>	new_edges;

	for (T u : graph->li_vertices)
	{
		for (T v : graph->li_edges[u])
		{
			new_edges[v].insert(u);
		}
	}
	graph->li_edges = new_edges;
}

template<typename T>
void	transpose_glaw(s_glaw<T> *graph)
{
	std::map<T, std::set<std::pair<T, double>>>		new_edges;

	for (T u : graph->li_vertices)
	{
		for (auto p : graph->li_edges[u])
		{
			T v = p.first;
			double w = p.second;
			new_edges[v].insert(std::make_pair(u, w));
		}
	}
	graph->li_edges = new_edges;
}
