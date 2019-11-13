import React from 'react';
import logo from './logo.svg';
import './App.css';
import List from "./components/List";
import dummyItems from "./items.json"
import EmptyState from './components/EmptyState';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      favItems: [],
      favShows: false,
      checked: false,
    };
  }

  handleChange = () => this.setState({ checked: !this.state.checked});



  handleFavItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({favItems : newItems});
  }

  handleItemClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = {...item};
    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    this.setState({favItems : newItems});
  }

  loadFav = checked => {
    if (checked === true && this.state.favItems.length > 0) { return(
            <div className="col-sm">
              <List
                title="My Favorite"
                items={this.state.favItems}
                onItemClick={this.handleFavItemClick}
                inputType="checkbox"
              />
          </div>
      );
    }else if (checked === true && this.state.favItems.length === 0) {
      return(
              <div className="col-sm">
                <EmptyState
                  title="My Favorite"
                />
              </div>
      );
    }
    
  }




  render() {
        const { favItems } = this.state;
        return (
        <div className="container-fluid">
            <h1 className="text-center">
              Welcome!
              <small>Class-based</small>
            </h1>
            <div className="row justify-content-center align-items center">
              <input type="checkbox" onChange={this.handleChange}/>
              <small>Show Favorite</small>
            </div>
          <div className="container pt-3">
            <div className="row">
              <div className="col-sm">
                <List
                  title="Our Menu"
                  items= {dummyItems}
                  onItemClick={this.handleItemClick}
                  inputType="hidden"
                  />
              </div>
              {this.loadFav(this.state.checked)}
            </div>
          </div>
        </div>

        );
  }
}


