# intializing blockchain list
blockchain = []
open_transactions = []
owner = 'Colin'

def get_last_blockchain_value():
    """ Returns last value of blockchain """
    if len(blockchain) < 1:
        return None
    return blockchain[-1]


def add_transaction(recipent, sender=owner, amount=1.0):
    """ Append a new value as well as last value, to the blockchain as the last val

    Arguments:
        :sender: Sender.
        :recipient: recipient
        :amount: amount
     """
    transaction = {
       'sender': sender,
       'recipient': recipient, 
       'amount': amount
    }
    
    open_transactions.append(transaction)
    print(blockchain)


def mine_block():
    pass


def get_transaction_value():
    tx_recipient = input('Enter recipient of transaction')
    tx_amount = float(input('Your transaction amount: '))
    return (tx_recipient, tx_amount)


def get_user_choice():
    return input('Your choice')


def print_blockchain_elements():
    for block in blockchain:
            print("Output block", block)


def verify_chain():
    block_index=0
    is_valid = True
    for block_index in range(len(blockchain)): # range goes from zero to len -1
        if block_index == 0:
            continue
        elif blockchain[block_index][0] == blockchain[block_index -1]:
            is_valid = True
        else:
            is_valid = False
            break
    return is_valid

waiting_for_input = True

while waiting_for_input:
    print('Please choose:   ')
    print('1: Add a new transactions' )
    print('2: Output the blockchain blocks' )
    print('q: Exit')
    print('h: Manipulate the chain')
    user_choice = get_user_choice()

    if user_choice == '1':
        tx_data = get_transaction_value()
        recipient, amount = tx_data # using list comprehension
        add_transaction(recipient, amount=amount)
        print(open_transactions)
    elif user_choice =="2":
        print_blockchain_elements()
    elif user_choice == "q":
        waiting_for_input = False
    elif user_choice == 'h':
        if len(blockchain) >=1:
            blockchain[0] = 2
    else:
        print('Invalid value , please select a value from the list.')
    if not verify_chain():
        print('Invalid blockchain')
        break
else:
    print('Exicting program')
