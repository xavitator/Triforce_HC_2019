
#include "libalgo.hpp"

template<typename T>
void	heap_make(std::vector<T> &v)
{
	std::make_heap(v.begin(), v.end());
}

template<typename T>
void	heap_push(std::vector<T> &v, T && u)
{
	v.push_back(u);
	std::push_heap(v.begin(), v.end());
}

template<typename T>
T		heap_pop(std::vector<T> &v)
{
	T	u;

	std::pop_heap(v.begin(), v.end());
	u = v.back();
	v.pop_back();
	return (u);
}

template<typename T>
void	heap_rev_make(std::vector<T> &v)
{
	std::make_heap(v.begin(), v.end(), std::greater<T>());
}

template<typename T>
void	heap_rev_push(std::vector<T> &v, T && u)
{
	v.push_back(u);
	std::push_heap(v.begin(), v.end(), std::greater<T>());
}

template<typename T>
T		heap_rev_pop(std::vector<T> &v)
{
	T	u;

	std::pop_heap(v.begin(), v.end(), std::greater<T>());
	u = v.back();
	v.pop_back();
	return (u);
}
