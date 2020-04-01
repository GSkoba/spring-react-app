import React from 'react';
import './App.css';

interface IProps {}

interface ITodo {
  id: string;
  title: string;
  status: boolean;
}

interface IState {
  todos: ITodo[];
  text: string;
}

class TodoApp extends React.Component<IProps, IState> {

  state: IState = {
    text: '',
    todos: []
  }

  componentDidMount() : void {
    fetch('http://localhost:8080/fetchAll')
    .then((resp) => {
        return resp.json();
    })
    .then((data) => {
        this.setState({
            todos: data
        })
    })
    .catch((error) => console.log(error))
  }

  handleChange(e: React.FormEvent<HTMLInputElement>) : void {
    this.setState({ text: (e.target as HTMLInputElement).value });
  }

  handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    if (!this.state.text.length) {
      return;
    }
    const newItem = {
      title: this.state.text
    };

    fetch('http://localhost:8080/addTodo', {
        method: 'POST',
        body: JSON.stringify({title: newItem.title}),
        headers: { 'Content-Type': 'application/json; charset=utf-8'}
      })
      .then((resp) => {
          return resp.json()
      })
      .then((data) => {
          this.setState(state => ({
              todos: state.todos.concat(data),
              text: ''
            }));
      })
  }
  
  _handleRemoveItem(id: string) : void {
      fetch('http://localhost:8080/delete?id=' + id)
      .then((resp) => resp.json())
      .then((data) => {
          this.setState({
              todos: data
          })
      })
  }

  render() {
    return (
      <div>
      <h1>Todo List</h1>
      <div className="content">
      <form onSubmit={this.handleSubmit.bind(this)}>
        <input
          onChange={this.handleChange.bind(this)}
          value={this.state.text}
          placeholder="What we need to done?"
        />
      </form>
      <ul className="todoList">
      {this.state.todos.map((item) => (
          <div className="todoItem">
        <li key={item.id}>{item.title}</li>
        <button onClick={(e) => this._handleRemoveItem(item.id)}>x</button>
        </div>
      ))}
    </ul> 
    </div>
    </div>
    )
  }
}
export default TodoApp;
