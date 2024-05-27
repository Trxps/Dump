private void createButton() {
    button = new JButton("Start counter");
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            button.setEnabled(false); // can't click while counter is running
            Thread background = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 50; i++) {
                        try {
                            Thread.sleep(100);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
                        count.setText(Integer.toString(i));
                    }
                    button.setEnabled(true); //click-able after the counter ends
                }
            });
            background.start();
        }
    });
}