#!/bin/bash
fuser -k 8000/tcp
lsof -t -i:8000
python3 pyserver.py