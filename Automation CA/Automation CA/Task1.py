import csv

list_file = []

str_packets = []
str_tx = []
str_rx = []

with open('Sample for task 1.csv', newline='') as f:
    reader = csv.reader(f)
    list_file = list(reader)

for item in list_file:
    tempItem = ''.join(item)
    temp = tempItem.split(',')
    str_packets.extend(temp[2])
    str_tx.extend(temp[4])
    str_rx.extend(temp[6])

str_packets.pop(0)
str_tx.pop(0)
str_rx.pop(0)

int_packets = []
int_tx = []
int_rx = []

for val in str_packets:
    int_packets.extend(int(val))
for val in str_tx:
    int_tx.extend(int(val))
for val in str_rx:
    int_rx.extend(int(val))

tx_calc = []
rx_calc = []

for i in range(len(int_packets)):
    tx_calc.extend(round((int_tx[i] / int_packets[i]) * 100))
    rx_calc.extend(round((int_rx[i] / int_packets[i]) * 100))

textfile = open('Task2.tr', 'w')
for i in range(len(tx_calc)):
    text = str(rx_calc[i]) + '  ' + str(tx_calc[i])
    textfile.write(text)
    textfile.write('\n')
textfile.close()