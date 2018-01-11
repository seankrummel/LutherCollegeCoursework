from cs160graph import *
from cs160vertex import *
from cs160queue import *
import sys


def bfs(g, start):
    start.setDistance(0)
    start.setPred(None)
    vertQueue = Queue()
    vertQueue.enqueue(start)
    while vertQueue.size() > 0:
        currentVert = vertQueue.dequeue()
        for nbr in currentVert.getConnections():
            if nbr.getColor() == 'white':
                nbr.setColor('gray')
                nbr.setDistance(currentVert.getDistance() + 1)
                nbr.setPred(currentVert)
                vertQueue.enqueue(nbr)
        currentVert.setColor('black')


def main():
    actors = {}
    movies = {}

    f = open("actors.txt", "r")
    for line in f:
        x = line[:-1].split("|")
        actors[int(x[0])] = x[1]
    f.close()
    # fill actors dictionary with actors.txt

    f = open("movies.txt", "r")
    for line in f:
        x = line[:-1].split("|")
        movies[int(x[0])] = x[1]
    f.close()
    # fill movies dictionary with movies.txt

    g = Graph()
    for key in actors:
        g.addVertex(key)
    # make a vertex for every actor

    f = open("movieactors.txt", "r")
    prevmovie = 1
    actlist = []
    for line in f:
        x = line[:-1].split("|")
        movie = int(x[0])
        actor = g.getVertex(int(x[1]))
        if movie == prevmovie:
            actlist.append(actor)
        else:
            for i in actlist:
                for j in actlist:
                    if i != j:
                        i.addNeighbor(j, prevmovie)
            actlist = []
            actlist.append(actor)
            prevmovie = movie
    for i in actlist:
        for j in actlist:
            if i != j:
                i.addNeighbor(j, prevmovie)
    f.close()
    # using movieactors.txt, create edges that represent films that both actors were in

    bfs(g, g.getVertex(63))
    # breadth first search of g starting at Kevin Bacon(63)

    n = raw_input("Enter the name of an actor, or 'done'")
    while n != "done":
        l = actors.items()
        count = 0
        while count < len(l):
            if l[count][1] == n:
                break
            else:
                count += 1
        if count == len(l):
            print(n + " is not in our database.")
        else:
            key = l[count][0]
            d = g.getVertex(key).getDistance()
            if d == 0:
                print (n + " is Kevin Bacon")
            elif d == sys.maxsize:
                print(n + " is not connected to Kevin Bacon")
            else:
                print(n + " is " + str(d) + " steps from Kevin Bacon")
                while key != 63:
                    v = g.getVertex(key)
                    title = v.getWeight(v.getPred())
                    print(actors[key] + " was in the film " + movies[title] + " which also starred...")
                    key = g.getVertex(key).getPred().getId()
                print("Kevin Bacon")
        n = raw_input("Enter the name of an actor, or 'done'")


main()
