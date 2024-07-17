import React, { Component } from 'react';

export default class extends Component {
    constructor(props) {
        super(props);
        // this.value = this.props.begin;
        // this.step = this.props.step;
        this.state = {
            val: this.props.begin
        }
    }

    render() {
        return (
            <div>
                <button onClick={() => {
                    // anti-pattern
                    // this.value += this.step;
                    // this.render();

                    this.setState({
                        val: this.state.val + this.props.step
                    })
                }}>
                    <strong>
                        {'+'}
                    </strong>
                </button>
                {' '}
                <span>
                    {this.state.val}
                </span>
            </div>
        );
    }
}