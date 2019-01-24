
#include "libalgo.hpp"

template<typename T>
static int	graph_detect_until(
					s_gla<T> *graph,
					T u,
					std::set<T> &passed,
					std::set<T> &rec_actu)
{
	passed.insert(u);
	rec_actu.insert(u);

	for (T v : graph->li_edges[u])
	{
		if (passed.find(v) == passed.end() &&
				graph_detect_until(graph, v, passed, rec_actu))
			return (1);
		if (rec_actu.find(v) != rec_actu.end())
			return (1);
	}
	rec_actu.erase(u);
	return (0);
}

template<typename T>
int			graph_cycle_detect(s_gla<T> *graph)
{
	std::set<T>			passed;
	std::set<T>			rec_actu;

	for (T u : graph->li_vertices)
	{
		if (passed.find(u) == passed.end())
		{
			if (graph_detect_until(graph, u, passed, rec_actu))
				return (1);
		}
	}
	return (0);
}
