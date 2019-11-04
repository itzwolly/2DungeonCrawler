class Player:
    owner = None;
    
    def __init__(self, owner):
        self.owner = owner;
        Debug.Log("Created a python instance of class: " + self.owner.GetName())