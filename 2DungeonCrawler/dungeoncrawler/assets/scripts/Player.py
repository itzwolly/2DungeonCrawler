from com.wolly.dungeoncrawler.core import Vector2

class Player:
    owner = None
    
    def __init__(self, owner):
        self.owner = owner
        Debug.Log("Created a python instance of class: " + self.owner.GetName())

    def Update():
        owner.velocity = Vector2(1, 0)
        print("Just do print - Hayley")