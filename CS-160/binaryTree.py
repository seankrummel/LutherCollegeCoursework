class TreeNode:
    def __init__(self, newitem):
        self.data = newitem
        self.left = None
        self.right = None

    def setData(self, newdata):
        self.data = newdata

    def setLeft(self, newleft):
        self.left = newleft

    def setRight(self, newright):
        self.right = newright

    def getData(self):
        return self.data

    def getLeft(self):
        return self.left

    def getRight(self):
        return self.right

    def postorder(self):
        if self.left != None:
            self.left.postorder()
        if self.right != None:
            self.right.postorder()
        print(self.data)


class BinaryTree:
    def __init__(self):
        self.root = None

    def setRoot(self, newroot):
        self.root = newroot

    def getRoot(self):
        return self.root

    def postorder(self):
        if self.root != None:
            self.root.postorder()
