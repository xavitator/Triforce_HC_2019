
import java.util.*;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;


class Couplage{


	private static LinkedList<NodeC> aux_get_maxc (NodeC head, HashMap<NodeC, NodeC> couples, boolean marked, boolean[] visited){
		if(visited[head.getIndice()]) return null;
		visited[head.getIndice()] = true;
		LinkedList<NodeC> res = new LinkedList<>();
		if(marked){
			NodeC suiv = couples.get(head);
			res = aux_get_maxc(suiv, couples, !marked, visited);
			if(res == null) return null;
			res.addFirst(head);
			return res;
		}
		for (NodeC next : head.getNext()){
			if(! couples.containsKey(next) &&  ! visited[next.getIndice()]){
				assert(res != null);
				res.add(next);
				res.addFirst(head);
				return res;
			}
			LinkedList<NodeC> tmp = aux_get_maxc(next, couples, !marked, visited);
			if(tmp == null) continue;
			tmp.addFirst(head);
			return tmp;
		}
		return null;
	}

	public static LinkedList<NodeC[]> get_MaxC (NodeC head, HashMap<NodeC, NodeC> couples, int size){
		boolean[] visited = new boolean[size];
		LinkedList<NodeC> res = aux_get_maxc(head, couples, false, visited);
		if(res == null) return null;
		LinkedList<NodeC[]> ret = new LinkedList<>();
		for(int i = 0; i < res.size() - 1; i+=2){
			NodeC[] c = {res.get(i), res.get(i+1)};
			ret.add(c);
		}
		return ret;
	}

	public static LinkedList<NodeC[]> algoCouplage(NodeC [] graphe ){

		LinkedList<NodeC> nonMarque = new LinkedList<NodeC>();

		for( int i = 0 ; i < graphe.length ; i ++){
			nonMarque.add(graphe[i]);
		}

		HashMap <NodeC,NodeC> couple = new HashMap <NodeC,NodeC>();
		LinkedList < NodeC[]> cMax = new LinkedList<NodeC[]> ();
		while ( nonMarque.size() != 0  ){
			cMax = get_MaxC(nonMarque.peekFirst(), couple, graphe.length);
			if(cMax == null) break ; 
			
			for (int i = 0 ; i < cMax.size(); i ++){
				couple.put(cMax.get(i)[0],cMax.get(i)[1]);
				couple.put(cMax.get(i)[1],cMax.get(i)[0]);

				nonMarque.remove(cMax.get(i)[0]);
				nonMarque.remove(cMax.get(i)[1]);

			} 
		}
		NodeC [][] cleanCouple = new NodeC[graphe.length][];
		for ( Map.Entry<NodeC,NodeC> entry : couple.entrySet() ){
			if(cleanCouple[entry.getKey().getIndice()] == null){
				cleanCouple[entry.getValue().getIndice()] = new NodeC[2];
				cleanCouple[entry.getValue().getIndice()][0] = entry.getKey();
				cleanCouple[entry.getValue().getIndice()][1] = entry.getValue();  
			}
		}
		LinkedList <NodeC[]> r = new LinkedList <NodeC[]> () ;
		for(int i = 0 ; i < cleanCouple.length ; i ++ ){
			if(cleanCouple[i] != null){
				r.add(cleanCouple[i]);
			}
		}

		return r;

	}
}