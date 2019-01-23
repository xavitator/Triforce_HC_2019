#ifndef LIBALGO_HPP
# define LIBALGO_HPP

# include <iostream>
# include <set>
# include <map>
# include <deque>
# include <utility>

template<typename T>
struct	s_gla
{
	std::set<T>						li_vertices;
	std::map<T, std::set<T> >		li_edges;
};

#endif
