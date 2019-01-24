
#include "libalgo.hpp"

template<typename T>
struct	s_ret_bellman_ford
{
	std::map<T, T>		pi;
	std::map<T, double>	distance;
};

template<typename T>
struct	s_ret_bellman_ford<T>	*graph_bellman_ford(
										struct s_glaw<T> *graph,
										T s)
{
	struct s_ret_bellman_ford<T>		*res;

	// Step 1: initialize graph
	res = new struct s_ret_bellman_ford<T>;
	for (T u : graph->li_vertices)
	{
		res->distance[u] = std::numeric_limits<double>::infinity();
	}
	res->distance[s] = .0;

	// Step 2: relax edges repeatedly
	for (size_t i = 0; i < graph->li_vertices.size() - 1; ++i)
	{
		for (T u : graph->li_vertices)
		{
			for (auto vw : graph->li_edges_w[u])
			{
				T v = vw.first;
				double w = vw.second;
				if (res->distance[v] > res->distance[u] + w)
				{
					res->distance[v] = res->distance[u] + w;
					res->pi[v] = u;
				}
			}
		}
	}

	// Step 3: check for negative-weight cycles
	for (T u : graph->li_vertices)
	{
		for (auto vw : graph->li_edges_w[u])
		{
			T v = vw.first;
			double w = vw.second;
			if (res->distance[u] + w < res->distance[v])
			{
				delete res;
				return (NULL);
			}
		}
	}

	return (res);
}
