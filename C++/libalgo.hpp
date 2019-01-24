#ifndef LIBALGO_HPP
# define LIBALGO_HPP

# include <iostream>
# include <set>
# include <map>
# include <deque>
# include <utility>
# include <string>
# include <limits>

template<typename T>
struct	s_gla
{
	std::set<T>									li_vertices;
	std::map<T, std::set<T> >					li_edges;
};

template<typename T>
struct	s_glaw
{
	std::set<T>									li_vertices;
	std::map<T, std::set<std::pair<T, double>>>	li_edges_w;
};

#endif
