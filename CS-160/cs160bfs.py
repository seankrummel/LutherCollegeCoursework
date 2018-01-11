from cs160graph import Graph
from cs160vertex import Vertex
from cs160queue import Queue

def bfs(g,start):
  s = g.getVertex(start)
  s.setDistance(0)
  s.setPred(None)
  vertQueue = Queue()
  vertQueue.enqueue(s)
  while (vertQueue.size() > 0):        
    currentVert = vertQueue.dequeue()
    for nbr in currentVert.getConnections():          
      if (nbr.getColor() == 'white'):
        nbr.setColor('gray')
        nbr.setDistance(currentVert.getDistance() + 1)
        nbr.setPred(currentVert)
        vertQueue.enqueue(nbr)
    currentVert.setColor('black')
