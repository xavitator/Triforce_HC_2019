
#include "libalgo.hpp"

template<typename T>
struct	s_ret_bfs
{
	std::map<T, T>				pi;
	std::map<T, unsigned int>	distance;
};

template<typename T>
struct	s_ret_bfs<T>	*graph_bfs(
							struct s_gla<T> *graph,
							T s)
{
	struct s_ret_bfs<T>	*res;
	std::set<T>			passed;
	std::deque<T>		file;

	res = new struct s_ret_bfs<T>;
	passed.insert(s);
	res->distance[s] = 0;
	file.push_back(s);
	while (file.empty() == false)
	{
		T u = file.front();
		file.pop_front();
		for (T v : graph->li_edges[u])
		{
			if (passed.find(v) == passed.end())
			{
				passed.insert(v);
				res->distance[v] = res->distance[u] + 1;
				res->pi[v] = u;
				file.push_back(v);
			}
		}
	}
	return (res);
}
