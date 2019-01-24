
#include "libalgo.hpp"

template<typename T>
void	print_gla(s_gla<T> *graph)
{
	std::cout << "Printing gla graph" << std::endl;

	for (T u : graph->li_vertices)
	{
		for (T v : graph->li_edges[u])
		{
			std::cout << u << " -> " << v << std::endl;
		}
	}
}

template<typename T>
void	print_glaw(s_glaw<T> *graph)
{
	std::cout << "Printing glaw graph" << std::endl;

	for (T u : graph->li_vertices)
	{
		for (auto p : graph->li_edges[u])
		{
			T v = p.first;
			double w = p.second;
			std::cout << u << " -> " << v << " : " << w << std::endl;
		}
	}
}
